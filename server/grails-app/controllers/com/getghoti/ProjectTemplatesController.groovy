package com.getghoti

import org.springframework.dao.DataIntegrityViolationException

class ProjectTemplatesController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [projectTemplatesInstanceList: ProjectTemplates.list(params), projectTemplatesInstanceTotal: ProjectTemplates.count()]
    }

    def create() {
        [projectTemplatesInstance: new ProjectTemplates(params)]
    }

    def save() {
        def projectTemplatesInstance = new ProjectTemplates(params)
        if (!projectTemplatesInstance.save(flush: true)) {
            render(view: "create", model: [projectTemplatesInstance: projectTemplatesInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'projectTemplates.label', default: 'ProjectTemplates'), projectTemplatesInstance.id])
        redirect(action: "show", id: projectTemplatesInstance.id)
    }

    def show(Long id) {
        def projectTemplatesInstance = ProjectTemplates.get(id)
        if (!projectTemplatesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'projectTemplates.label', default: 'ProjectTemplates'), id])
            redirect(action: "list")
            return
        }

        [projectTemplatesInstance: projectTemplatesInstance]
    }

    def edit(Long id) {
        def projectTemplatesInstance = ProjectTemplates.get(id)
        if (!projectTemplatesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'projectTemplates.label', default: 'ProjectTemplates'), id])
            redirect(action: "list")
            return
        }

        [projectTemplatesInstance: projectTemplatesInstance]
    }

    def update(Long id, Long version) {
        def projectTemplatesInstance = ProjectTemplates.get(id)
        if (!projectTemplatesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'projectTemplates.label', default: 'ProjectTemplates'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (projectTemplatesInstance.version > version) {
                projectTemplatesInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'projectTemplates.label', default: 'ProjectTemplates')] as Object[],
                          "Another user has updated this ProjectTemplates while you were editing")
                render(view: "edit", model: [projectTemplatesInstance: projectTemplatesInstance])
                return
            }
        }

        projectTemplatesInstance.properties = params

        if (!projectTemplatesInstance.save(flush: true)) {
            render(view: "edit", model: [projectTemplatesInstance: projectTemplatesInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'projectTemplates.label', default: 'ProjectTemplates'), projectTemplatesInstance.id])
        redirect(action: "show", id: projectTemplatesInstance.id)
    }

    def delete(Long id) {
        def projectTemplatesInstance = ProjectTemplates.get(id)
        if (!projectTemplatesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'projectTemplates.label', default: 'ProjectTemplates'), id])
            redirect(action: "list")
            return
        }

        try {
            projectTemplatesInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'projectTemplates.label', default: 'ProjectTemplates'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'projectTemplates.label', default: 'ProjectTemplates'), id])
            redirect(action: "show", id: id)
        }
    }
}
