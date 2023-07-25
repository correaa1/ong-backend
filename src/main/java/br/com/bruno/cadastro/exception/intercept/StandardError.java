package br.com.bruno.cadastro.exception.intercept;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StandardError {
     Instant timestamp;
     Integer status;
     String error;
     String message;

}
