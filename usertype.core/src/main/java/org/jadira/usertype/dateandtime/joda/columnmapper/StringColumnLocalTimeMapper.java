/*
 *  Copyright 2010, 2011 Christopher Pheby
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.jadira.usertype.dateandtime.joda.columnmapper;

import org.jadira.usertype.dateandtime.joda.util.Formatter;
import org.jadira.usertype.spi.shared.AbstractStringColumnMapper;
import org.joda.time.LocalTime;

public class StringColumnLocalTimeMapper extends AbstractStringColumnMapper<LocalTime> {

    private static final long serialVersionUID = -6885561256539185520L;

    @Override
    public LocalTime fromNonNullValue(String s) {
        return new LocalTime(s);
    }

    @Override
    public String toNonNullValue(LocalTime value) {
        if (value.getMillisOfSecond() == 0) {
            if (value.getSecondOfMinute() == 0) {
                return Formatter.LOCAL_TIME_NOSECONDS_PRINTER.print(value);
            }
            return Formatter.LOCAL_TIME_NOMILLIS_PRINTER.print(value);
        } else {
            return value.toString();
        }
    }
}
