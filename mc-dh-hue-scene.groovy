/**
 *  Hue Bulb
 *
 *  Philips Hue Type "Scene"
 *
 *  Adapted by John McManigle 2018
 */

// for the UI
metadata {
	// Automatically generated. Make future change here.
	definition (name: "Hue Scene", namespace: "mcmanigle", author: "John McManigle") {
		capability "Momentary"
		capability "Switch"
        capability "Actuator"
        capability "Sensor"
	}

	simulator {
		// TODO: define status and reply messages here
	}

	tiles (scale: 2){
		multiAttributeTile(name:"switch", type: "generic", width: 6, height: 4, canChangeIcon: true){
			tileAttribute ("device.switch", key: "PRIMARY_CONTROL") {
				attributeState "off", label:"Enable", action:"momentary.push", icon:"st.lights.philips.hue-multi", backgroundColor:"#ffffff"
				attributeState "on", label:"Enable", action:"momentary.push", icon:"st.lights.philips.hue-multi", backgroundColor:"#00A0DC"
			}
			main "switch"
			details "switch"
		}
	}
}

def initialize() {
}

void installed() {
	log.debug "installed()"
	initialize()
}

def updated() {
	log.debug "updated()"
	initialize()
}

def parse(String description) {
}

def push() {
    log.trace parent.sceneOn(this)

    sendEvent(name: "switch", value: "off", isStateChange: false, displayed: false)
    sendEvent(name: "momentary", value: "pushed", isStateChange: true)
}

def on() {
    push()
}

def off() {
}
