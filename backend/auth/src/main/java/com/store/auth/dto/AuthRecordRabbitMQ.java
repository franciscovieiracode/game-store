package com.store.auth.dto;


import java.util.UUID;

public record AuthRecordRabbitMQ( String email,
                                  String name,
                                  UUID userId){

}

