package com.demo.products.mapper;

import com.demo.products.dto.ProductDTO;
import com.demo.products.entity.Product;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO entityToApi(Product product);

    @Mappings({
            @Mapping(target = "lastUpdate", ignore = true),
            @Mapping(target = "id", ignore = true),
    })
    Product apiToEntity(ProductDTO productDTO);

    List<ProductDTO> entityListToApiList(List<Product> entity);

    List<Product> apiListToEntityList(List<ProductDTO> api);
}
