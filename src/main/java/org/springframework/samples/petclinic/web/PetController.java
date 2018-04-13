/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Pets;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Juergen Hoeller
 * @author Mark Fisher
 * @author Ken Krebs
 * @author Arjen Poutsma
 */
@Controller
public class PetController {

    private final ClinicService clinicService;


    @Autowired
    public PetController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @RequestMapping(value = {"/pets.xml", "/pets.html"})
    public String showPetList(Map<String, Object> model) {
        // Here we are returning an object of type 'Pets' rather than a collection of Pet objects
        // so it is simpler for Object-Xml mapping
        Pets pets = new Pets();
        pets.getPetList().addAll(this.clinicService.findPets());
        model.put("pets", pets);
        return "pets/petList";
    }

    @RequestMapping("/pets.json")
    public
    @ResponseBody
    Pets showResourcesPetList() {
        // Here we are returning an object of type 'Pets' rather than a collection of Pet objects
        // so it is simpler for JSon/Object mapping
        Pets pets = new Pets();
        pets.getPetList().addAll(this.clinicService.findPets());
        return pets;
    }


}
