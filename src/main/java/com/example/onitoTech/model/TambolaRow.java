package com.example.onitoTech.model;



import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import java.util.List;

@Entity
public class TambolaRow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "tambola_numbers", joinColumns = @JoinColumn(name = "row_id"))
    private List<Integer> numbers;

   

    public TambolaRow() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

	public TambolaRow(Long id, List<Integer> numbers) {
		super();
		this.id = id;
		this.numbers = numbers;
	}



	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}

