package com.perfios

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PlayersServiceSpec extends Specification {

    PlayersService playersService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Players(...).save(flush: true, failOnError: true)
        //new Players(...).save(flush: true, failOnError: true)
        //Players players = new Players(...).save(flush: true, failOnError: true)
        //new Players(...).save(flush: true, failOnError: true)
        //new Players(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //players.id
    }

    void "test get"() {
        setupData()

        expect:
        playersService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Players> playersList = playersService.list(max: 2, offset: 2)

        then:
        playersList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        playersService.count() == 5
    }

    void "test delete"() {
        Long playersId = setupData()

        expect:
        playersService.count() == 5

        when:
        playersService.delete(playersId)
        sessionFactory.currentSession.flush()

        then:
        playersService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Players players = new Players()
        playersService.save(players)

        then:
        players.id != null
    }
}
