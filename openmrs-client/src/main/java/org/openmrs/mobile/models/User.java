/*
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.mobile.models;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class User extends BaseOpenmrsObject implements Serializable {
    private static final long serialVersionUID = 1L;

    private String personUuid;

    @Expose
    private String username;

    @Expose
    private String systemId;

    @Expose
    private Person person;

    @Override
    public void refreshDaoProperties() {
        super.refreshDaoProperties();

        if (person != null) {
            personUuid = person.getUuid();
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
