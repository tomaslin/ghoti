package com.getghoti

class ProjectTemplates {

	Date dateCreated
	Date lastUpdated
	String name
	String description
	String url

    static constraints = {
    	name()
		description()
		url(url:true)
	}
}
