package com.ibm.developer.produce;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/produce")
public class ProduceController {

	private ProduceRepo repo;
	private ProduceService service;

	public ProduceController(ProduceRepo repo, ProduceService service) {
		this.repo = repo;
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<Iterable<Produce>> findAllProduce() {
		return ResponseEntity.ok(repo.findAll());
	}

	@GetMapping("/{name}")
	public ResponseEntity<Iterable<Produce>> findProduceByName(@PathVariable String name) {
		return ResponseEntity.ok(repo.findByName(name));
	}
//
//	@PostMapping//INITIAL
//	public ResponseEntity<Produce> addNewProduce(@RequestBody Produce produce) {
//		return ResponseEntity.ok(repo.save(produce));
//	}
//	
	@PostMapping//FINAL
	public ResponseEntity<Produce> addNewProduce(@RequestBody Produce produce) {
		return ResponseEntity.ok(service.addNewProduce(produce));
	}

	@ExceptionHandler(ClientException.class)
	public ResponseEntity<Object> returnClientErrorMessage(ClientException e) {
		return ResponseEntity.badRequest().body(new ErrorMessage(e.getMessage()));
	}

	class ErrorMessage {
		private String errorMessage;

		public ErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}

		public String getErrorMessage() {
			return errorMessage;
		}

	}
}
