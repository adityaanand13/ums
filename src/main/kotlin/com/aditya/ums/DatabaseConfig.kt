package com.aditya.ums

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import javax.sql.DataSource

@Configuration
class DatabaseConfig(
        @Value("mysql://bbb5259286f040:00108b6c@us-cdbr-iron-east-04.cleardb.net/heroku_f1ea9b20098bd93?reconnect=true")
        private val dbUrl: String
)
{
    @Bean
    fun dataSource() : DataSource {
        val config = HikariConfig()
        config.jdbcUrl = dbUrl
        return HikariDataSource(config)
    }
}