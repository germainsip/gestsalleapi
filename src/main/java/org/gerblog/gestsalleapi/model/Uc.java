package org.gerblog.gestsalleapi.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Uc {
    @Id
    private Long id;
    private String patrimoine;
    private boolean enFonction;
    private boolean mouse;
    private int screen;
    private boolean keyboard;

}
