/*
 *
 *  * ---------------------------------------------------------------------------------------------
 *  *  *  Copyright (c) IJSE-intern. All rights reserved.
 *  *  *  Licensed under the MIT License. See License.txt in the project root for license information.
 *  *  --------------------------------------------------------------------------------------------/
 *
 */

package lk.ijse.accessingdatamongodb.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Nipun Chathuranga <nipunc1999@gmail.com>
 * @since : 4/11/2021
 **/

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StandardResponse {
    private int code;
    private String message;
    private Object data;
}
