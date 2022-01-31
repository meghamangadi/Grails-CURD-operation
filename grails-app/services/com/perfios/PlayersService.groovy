package com.perfios

import grails.gorm.services.Service

@Service(Players)
interface PlayersService {

    Players get(Serializable id)

    List<Players> list(Map args)

    Long count()

    void delete(Serializable id)

    Players save(Players players)

}