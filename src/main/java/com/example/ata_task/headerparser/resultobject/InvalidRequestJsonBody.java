package com.example.ata_task.headerparser.resultobject;

import com.example.ata_task.jsonresponse.CustomJsonSerializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Objects of this class store invalid request data ready to be serialized.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvalidRequestJsonBody implements CustomJsonSerializable {

    private int status;

    private String Message;
}
