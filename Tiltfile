allow_k8s_contexts('k8s-cluster')

load('ext://restart_process', 'docker_build_with_restart')
registry = 'harbor.sheldan.dev/crimson/'
abstracto_registry = 'harbor.sheldan.dev/abstracto/'

local_resource(
  'crimson-java-compile',
  ' mvn install && ' +
  ' rm -rf application/executable/target/jar-staging && ' +
  ' unzip -o application/executable/target/crimson-exec.jar -d application/executable/target/jar-staging && ' +
  ' rsync --delete --delete-excluded --inplace --checksum --exclude="*-SNAPSHOT.jar" -r application/executable/target/jar-staging/ application/executable/target/jar && ' +
  ' rm -rf application/executable/target/jar/snapshots && ' +
  ' mkdir application/executable/target/jar/snapshots && ' +
  ' rsync --delete --delete-excluded --inplace --checksum --include="*/" --include="*-SNAPSHOT.jar" --exclude="*" -r application/executable/target/jar-staging/BOOT-INF/lib/ application/executable/target/jar/snapshots',
  deps=['pom.xml'], auto_init=False, trigger_mode = TRIGGER_MODE_MANUAL)

docker_build_with_restart(
  registry + 'crimson-bot',
  './application/executable/target/jar',
  entrypoint=['java', '-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005', '-cp', '.:./lib/*', 'dev.sheldan.crimson.executable.Application'],
  dockerfile='./application/executable/Dockerfile',
  live_update=[
    sync('./application/executable/target/jar/BOOT-INF/lib', '/app/lib'),
    sync('./application/executable/target/jar/META-INF', '/app/META-INF'),
    sync('./application/executable/target/jar/BOOT-INF/classes', '/app'),
    sync('./application/executable/target/jar/snapshots', '/app/lib')
  ],
)

docker_build(registry + 'crimson-db-data', 'deployment/image-packaging/src/main/docker/db-data/')
update_settings(suppress_unused_image_warnings=[registry + "crimson-image-gen-api"]) # only used in docker image building
docker_build(registry + 'crimson-private-rest-api', 'deployment/image-packaging/src/main/docker/private-rest-api/', build_args={'REGISTRY_PREFIX': abstracto_registry, 'CRIMSON_REGISTRY_PREFIX': registry})
docker_build(registry + 'crimson-template-data', 'deployment/image-packaging/src/main/docker/template-data/')


local('cd tilt/crimson-dev && helm dep up')
k8s_yaml(helm('tilt/crimson-dev', values=
['./../crimson-environments/argocd/apps/crimson/values/local/values.yaml',
'secrets://./../crimson-environments/argocd/apps/crimson/values/local/values.secrets.yaml']
))

local_resource('fetch-packages', 'mvn install -f deployment/image-packaging/pom.xml', auto_init=False, trigger_mode = TRIGGER_MODE_MANUAL)
k8s_resource('chart-crimson', port_forwards='5005:5005')