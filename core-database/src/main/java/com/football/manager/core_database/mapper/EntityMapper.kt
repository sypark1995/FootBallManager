package com.football.manager.core_database.mapper

interface EntityMapper<Domain, Entity> {

    fun asEntity(season: Long, domain: Domain): Entity

    fun asDomain(entity: Entity): Domain
}