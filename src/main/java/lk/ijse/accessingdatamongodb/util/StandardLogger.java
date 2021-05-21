/*
 *
 *  * ---------------------------------------------------------------------------------------------
 *  *  *  Copyright (c) IJSE-intern. All rights reserved.
 *  *  *  Licensed under the MIT License. See License.txt in the project root for license information.
 *  *  --------------------------------------------------------------------------------------------/
 *
 */

package lk.ijse.accessingdatamongodb.util;

/**
 * @author : Nipun Chathuranga <nipunc1999@gmail.com>
 * @since : 4/13/2021
 **/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StandardLogger {
    private String type;
    private String message;
}
