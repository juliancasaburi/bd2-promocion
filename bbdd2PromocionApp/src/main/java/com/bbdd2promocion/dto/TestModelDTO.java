/**
 * Este paquete contiene las clases que se utilizan para transferir información de las
 * distintas instancias entre capas.
 */
package com.bbdd2promocion.dto;

import java.util.UUID;

/**
 * Las instancias de esta clase se utilizan para transferir información de los
 * TestModel.
 */
public class TestModelDTO {

    /**
     * Identificador de cada una de las instancias.
     */
    private String id;

    /**
     * Es el title del TestModel.
     */
    private String title;

    /**
     * Es la description del TestModel.
     */
    private String description;

    /**
     * Constructor.
     *
     * @param anId       es el identificador del TestModel.
     * @param aTitle es el title del TestModel.
     * @param aDescription es la description del TestModel.
     */
    public TestModelDTO(String anId, String aTitle, String aDescription) {
        this.setId(anId);
        this.setTitle(aTitle);
        this.setDescription(aDescription);
    }

    /**
     * Getter.
     *
     * @return el identificador de esta instancia.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Setter.
     *
     * @param anId es el identificador de esta instancia.
     */
    public void setId(String anId) {
        this.id = anId;
    }

    /**
     * Getter.
     *
     * @return el title de este TestModel.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Setter.
     *
     * @param aTitle es el title de este TestModel.
     */
    public void setTitle(String aTitle) {
        this.title = aTitle;
    }

    /**
     * Getter.
     *
     * @return la description del TestModel.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Setter.
     *
     * @param aDescription es la description de este TestModel.
     */
    public void setDescription(String aDescription) {
        this.description = aDescription;
    }

}
