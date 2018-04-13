package org.springframework.samples.petclinic.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Simple domain object representing a list of pets. Mostly here to be used for the 'pets' {@link
 * org.springframework.web.servlet.view.xml.MarshallingView}.
 *
 * @author Leshi Wang
 */
@XmlRootElement
public class Pets {

    private List<Pet> pets;

    @XmlElement
    public List<Pet> getPetList() {
        if (pets == null) {
            pets = new ArrayList<>();
        }
        return pets;
    }

}
