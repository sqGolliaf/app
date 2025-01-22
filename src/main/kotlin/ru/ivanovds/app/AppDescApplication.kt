package ru.ivanovds.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AppDescApplication

fun main(args: Array<String>) {
	runApplication<AppDescApplication>(*args)
}
