package cz.bee_kingdom.rest_api.dto.treatment;

import lombok.Data;

import java.sql.Date;

@Data
public class TreatmentDTO {
    private Date dateTime;
    private Long id;
    private Long idColony;
    private String idType;
}
