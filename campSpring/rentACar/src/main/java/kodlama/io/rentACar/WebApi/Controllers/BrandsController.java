package kodlama.io.rentACar.WebApi.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import kodlama.io.rentACar.Business.Abstracts.BrandService;
import kodlama.io.rentACar.Business.requests.CreateBrandRequest;
import kodlama.io.rentACar.Business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.Business.response.GetAllBrandsResponse;
import kodlama.io.rentACar.Business.response.GetByIdResponse;

@RestController
@RequestMapping("/api/brands")

public class BrandsController {
	BrandService brandService;

	public BrandsController(BrandService brandService) {
		this.brandService = brandService;
	}
	@GetMapping()
	public List<GetAllBrandsResponse> getAll(){
		return brandService.getAll();
	}
	@GetMapping("/{id}")
	public GetByIdResponse getById(@PathVariable int id){
		return brandService.getById(id);
	}
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid	CreateBrandRequest createBrandRequest) {
		this.brandService.add(createBrandRequest);
	}
	@PutMapping()
	public void update(@RequestBody UpdateBrandRequest updateBrandRequest) {
		this.brandService.update(updateBrandRequest);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.brandService.delete(id);
	}

}
