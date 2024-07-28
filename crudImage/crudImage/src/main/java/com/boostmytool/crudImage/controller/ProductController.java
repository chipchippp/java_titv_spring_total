package com.boostmytool.crudImage.controller;

import com.boostmytool.crudImage.dto.ProductDto;
import com.boostmytool.crudImage.enity.Product;
import com.boostmytool.crudImage.service.product.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.*;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String listAllProducts(Model model) {
        List<Product> products = productService.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("products", products);
        return "product/index";
    }

    @GetMapping("/create")
    public String createProductForm(Model model) {
        ProductDto productDto = new ProductDto();
        model.addAttribute("productDto", productDto);
        return "product/create";
    }

    @PostMapping("/save")
    public String saveProduct(@Valid @ModelAttribute ProductDto productDto, BindingResult result) {
        if (productDto.getImageFile() == null || productDto.getImageFile().isEmpty()) {
            result.addError(new FieldError("productDto", "imageFile", "Image is required"));
            return "product/create";
        }

        if (result.hasErrors()) {
            return "product/create";
        }

        MultipartFile imageFile = productDto.getImageFile();
        Date createAt = new Date();
        String storageFileName = createAt.getTime() + "_" + imageFile.getOriginalFilename();

        try {
            String uploadDir = "public/images/";
            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            try (InputStream inputStream = imageFile.getInputStream()) {
                Files.copy(inputStream, Paths.get(uploadDir + storageFileName),
                        StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (Exception e) {
            e.getMessage();
        }

        Product product = new Product();
        product.setName(productDto.getName());
        product.setBrand(productDto.getBrand());
        product.setCategory(productDto.getCategory());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setImageFileName(storageFileName);
        productService.save(product);

        return "redirect:/product";
    }

    @GetMapping("/edit")
    public String editProductForm(Model model, @RequestParam Long id) {

        try {
            Product product = productService.findById(id);
            if (product == null) {
                return "redirect:/product";
            }
            model.addAttribute("product", product);

            ProductDto productDto = new ProductDto();
            productDto.setName(product.getName());
            productDto.setBrand(product.getBrand());
            productDto.setCategory(product.getCategory());
            productDto.setPrice(product.getPrice());
            productDto.setDescription(product.getDescription());
            model.addAttribute("productDto", productDto);
        } catch (Exception e) {
            e.getMessage();
            return "redirect:/product";
        }

        return "product/edit";
    }

    @PostMapping("/edit")
    public String updateProduct(@Valid @ModelAttribute ProductDto productDto, BindingResult result, Model model, @RequestParam Long id) {
        try{
            if (result.hasErrors()) {
                return "product/edit";
            }
            Product product = productService.findById(id);
            if (product == null) {
                return "redirect:/product";
            }
//            model.addAttribute("product", product);


            if (!productDto.getImageFile().isEmpty()) {
                String uploadDir = "public/images/";
                Path uploadPath = Paths.get(uploadDir + product.getImageFileName());
                try {
                    Files.delete(uploadPath);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                MultipartFile imageFile = productDto.getImageFile();
                Date createAt = new Date();
                String storageFileName = createAt.getTime() + "_" + imageFile.getOriginalFilename();
                try (InputStream inputStream = imageFile.getInputStream()) {
                    Files.copy(inputStream, Paths.get(uploadDir + storageFileName),
                            StandardCopyOption.REPLACE_EXISTING);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                product.setImageFileName(storageFileName);
            }

            product.setName(productDto.getName());
            product.setBrand(productDto.getBrand());
            product.setCategory(productDto.getCategory());
            product.setPrice(productDto.getPrice());
            product.setDescription(productDto.getDescription());

            productService.update(product);

        } catch (Exception e) {
            e.getMessage();
            return "redirect:/product";
        }
        return "redirect:/product";
    }

    @GetMapping("/delete")
    public String updateStudent(@RequestParam("id") Long id, Model model) {
        try {
            Product product = productService.findById(id);

            Path imagePath = Paths.get("public/images/" + product.getImageFileName());

            try {
                Files.delete(imagePath);
            } catch (Exception e) {
                e.getMessage();
            }
            productService.deleteById(id);
        } catch (Exception e) {
            e.getMessage();
            return "redirect:/product";
        }
        return "redirect:/product";
    }
}
