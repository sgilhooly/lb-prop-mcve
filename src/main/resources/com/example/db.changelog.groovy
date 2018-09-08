package com.example


databaseChangeLog {
    property(name: 'now_statement', value: 'EXTRACT(EPOCH FROM CURRENT_TIMESTAMP)', dbms='h2')
    property(name: 'now_statement', value: 'UNIX_TIMESTAMP()', dbms='mysql')
    changeSet(id: '2018.08.09', author: 'sean.gilhooly') {
        createTable(tableName: 'user') {
            column(name: 'id', type: 'varchar(36)') {
                constraints(nullable: true, primaryKey: true)
            }
            column(name: 'created_on', type: 'bigint', defaultValueComputed: '${now_statement}') {
            //column(name: 'created_on', type: 'bigint', defaultValueComputed: 'EXTRACT(EPOCH FROM CURRENT_TIMESTAMP)') {
                constraints(nullable: false)
            }
        }
    }
}
