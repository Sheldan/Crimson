# Crimson Discord bot privacy policy

Last updated: 23.02.2025

## Description

The bot requires some information to function properly and in a reasonable way.
The detailed list of what information is stored and processed is the following:

### General
* your Discord user ID is used to uniquely identify you and associate various properties, such as experience, level, opened modmail threads etc
* **no message content, username, channel name or role name is stored, except at the places where its mentioned**
* most of the stored records have a 'created' and 'updated' timestamp, in order to assist in examining bugs and malfunctions

### Reminder
* **the message content** in order to provide you with the reminder text
* the date it was created, and the date it is due
* whether you have been reminded

### Custom commands
* the **names** given to custom commands and the configured **response text**

## Grafana dashboard

There is also a [Grafana](https://grafana.com/) dashboard in order to inspect how the bot is operating.
The information visible in this dashboard is:

* message events
* Discord gateway ping
* starboard reactions
* amount of command executions
* emotes currently being processed for tracking
* embedded messages
* invite filter activity
* amount of experience which is currently being processed

All of this information cannot be linked to any user (or any server for that matter, if the bot would be in multiple servers) and is deleted after 15 days.


## How can I decide which information is collected?
It is not possible to opt-out of singular sub-services of the bot. Should you decide that your information should not be collected, please cease usage of the bot immediately (leave any guild the bot operates in).

_Should you decide to no longer utilize the bot, you may request your data to be erased within 30 days as per GDPR if you are a citizen of the EU. You can do this by sending a message to the user "sheldan" on Discord: GDPR Data removal <Username> <UserId>. If your request is incomplete, we cannot acknowledge it and therefore your data will not be removed. In order to identify authentic requests, please contact modmail beforehand by sending a direct message to the bot and stating your intention._


## Open source content
This bot uses the following open source libraries and frameworks:

* [abstracto](https://github.com/Sheldan/abstracto) is used as a base for this bot, providing most of the functionalities
* [JDA](https://github.com/DV8FromTheWorld/JDA/) The Discord API Wrapper used
* [Spring boot](https://github.com/spring-projects/spring-boot) is used as a framework to create standalone application in Java with Java EE methods. (including Dependency injection and more)
* [Hibernate](https://github.com/hibernate/hibernate-orm) is used as a reference implementation of JPA.
* [Freemarker](https://github.com/apache/freemarker) is used as a templating engine. This is used to provide internationalization for user facing text and enable dynamic embed configuration.
* [Ehcache](https://github.com/ehcache/ehcache3) is used as a caching implementation.
* [Lombok](https://github.com/rzwitserloot/lombok) is used as a framework in order to speed up creation of container classes and builders.
* [Quartz](https://github.com/quartz-scheduler/quartz) is used as a scheduling framework in order to provide functionalities which either require a delayed or cronjob behaviour.
* [Docker](https://github.com/docker) is used to package the application into a container and [k3s](https://k3s.io/) to orchestrate the containers
* [Liquibase](https://github.com/liquibase/liquibase) is used to manage changes to the database
* [Prometheus](https://prometheus.io) to scrap and collect the metrics about how the bot is operating

* [Grafana](https://grafana.com) to visualize metrics of the bot and [Loki](https://grafana.com/oss/loki/) for logging
