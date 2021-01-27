package com.poc.controller.autor;

import com.poc.controller.autor.dto.AutorCreate;
import com.poc.controller.autor.dto.AutorReturn;
import com.poc.controller.autor.dto.AutorUpdate;
import com.poc.entity.Autor;
import com.poc.services.AutorService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/autors")
public class AutorController {
	private final AutorService autorService;
	private final ModelMapper modelMapper;

	public AutorController(AutorService autorService, ModelMapper modelMapper) {
		this.autorService = autorService;
		this.modelMapper = modelMapper;
	}

	@PostMapping("")
	public ResponseEntity<AutorReturn> createBook(@RequestBody @Validated AutorCreate autor) {
		Optional<AutorReturn> result = Optional.of(autor)
				.map(entity -> modelMapper.map(entity, Autor.class))
				.flatMap(autorService::createAutor)
				.map(entity -> modelMapper.map(entity, AutorReturn.class));
		return ResponseEntity.of(result);
	}

	@GetMapping("")
	public ResponseEntity<List<AutorReturn>> getAllAutors() {
		List<AutorReturn> autors = autorService.getAllAutors()
				.map(entity -> modelMapper.map(entity, AutorReturn.class))
				.collect(Collectors.toList());
		return ResponseEntity.ok(autors);
	}

	@GetMapping("/{uuid}")
	public ResponseEntity<AutorReturn> getAutor(@PathVariable UUID uuid) {
		Optional<AutorReturn> result = autorService.getAutor(uuid)
				.map(entity -> modelMapper.map(entity, AutorReturn.class));
		return ResponseEntity.of(result);
	}

	@PatchMapping("/{uuid}")
	public ResponseEntity<AutorReturn> updateAutor(@PathVariable UUID uuid, @RequestBody @Validated AutorUpdate autor) {
		Optional<AutorReturn> result = Optional.of(autor)
				.map(entity -> modelMapper.map(entity, Autor.class))
				.flatMap(p -> autorService.updateAutor(uuid, p))
				.map(entity -> modelMapper.map(entity, AutorReturn.class));
		return ResponseEntity.of(result);
	}
}
