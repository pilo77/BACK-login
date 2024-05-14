package com.example.loginback.Security.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


public enum Role {
    ADMIN,
    USER
}