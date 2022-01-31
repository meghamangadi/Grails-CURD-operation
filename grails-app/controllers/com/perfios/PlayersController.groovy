package com.perfios

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PlayersController {

    PlayersService playersService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond playersService.list(params), model:[playersCount: playersService.count()]
    }

    def show(Long id) {
        respond playersService.get(id)
    }

    def create() {
        respond new Players(params)
    }

    def save(Players players) {
        if (players == null) {
            notFound()
            return
        }

        try {
            playersService.save(players)
        } catch (ValidationException e) {
            respond players.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'players.label', default: 'Players'), players.id])
                redirect players
            }
            '*' { respond players, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond playersService.get(id)
    }

    def update(Players players) {
        if (players == null) {
            notFound()
            return
        }

        try {
            playersService.save(players)
        } catch (ValidationException e) {
            respond players.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'players.label', default: 'Players'), players.id])
                redirect players
            }
            '*'{ respond players, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        playersService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'players.label', default: 'Players'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'players.label', default: 'Players'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
