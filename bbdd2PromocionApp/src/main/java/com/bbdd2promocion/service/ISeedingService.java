/**
 * Este paquete contiene todas las clases e interfaces que componen la capa de servicios.
 */
package com.bbdd2promocion.service;

import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;

public interface ISeedingService {

    /**
     * Inicia un Job de seeding para el model TestModel (MongoDB)
     *
     */
    void seedTestModelMongoDB() throws JobExecutionAlreadyRunningException, JobRestartException,
            JobInstanceAlreadyCompleteException, JobParametersInvalidException;

    /**
     * Inicia un Job de seeding para el model TestModel (Postgresql)
     *
     */
    void seedTestModelPostgreSQL() throws JobExecutionAlreadyRunningException, JobRestartException,
            JobInstanceAlreadyCompleteException, JobParametersInvalidException;

    /**
     * Inicia un Job de seeding para el model Accident (MongoDB)
     *
     */
    void seedAccidentMongoDB() throws JobExecutionAlreadyRunningException, JobRestartException,
            JobInstanceAlreadyCompleteException, JobParametersInvalidException;

    /**
     * Inicia un Job de seeding para el model Accident(Postgresql)
     *
     */
    void seedAccidentPostgreSQL() throws JobExecutionAlreadyRunningException, JobRestartException,
            JobInstanceAlreadyCompleteException, JobParametersInvalidException;

}
