package ru.skubatko.dev.otus.test.config.context

import kotlin.system.exitProcess

fun failFast() {
//    throw IllegalStateException("Second application context start attempt")
    println(
        """
    ####################################################
    #     SECOND APPLICATION CONTEXT START ATTEMPT.    #
    #     -----------------------------------------    #
    #  Please look upper for the reason why Spring is  #
    #  trying to recreate test context.  This can be   #
    #  caused by adding an @Import/@MockBean and some  #
    #  other annotations to the test class.            #
    #                                                  #
    #  This process will now exit immediately.         #
    ####################################################
        """
    )
    exitProcess(-1)
}
