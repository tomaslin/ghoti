package com.getghoti

import grails.converters.JSON

class FeedController {

	def index(){
		
	}

	def find(String projectName){
		
	}
	
	def list(){		
		render ProjectTemplates.approvedTemplates.list()?.sort{ it.name } as JSON
	}
}
