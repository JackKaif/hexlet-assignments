package exercise.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import exercise.dto.ProductParamsDTO;
import exercise.model.Product;

// BEGIN
@Component
public class ProductSpecification {
    public Specification<Product> build(ProductParamsDTO params) {
        return titleContainsString(params.getTitleCont())
                .and(inCategory(params.getCategoryId()))
                .and(priceGreaterThan(params.getPriceGt()))
                .and(priceLessThan(params.getPriceLt()))
                .and(ratingGreaterThan(params.getRatingGt()));
    }

    public Specification<Product> inCategory(Long categoryId) {
        return (root, query, criteriaBuilder) ->
                categoryId == null
                        ? criteriaBuilder.conjunction()
                        : criteriaBuilder.equal(root.get("category").get("id"), categoryId);
    }

    public Specification<Product> priceGreaterThan(Integer priceLt) {
        return (root, query, criteriaBuilder) ->
                priceLt == null
                        ? criteriaBuilder.conjunction()
                        : criteriaBuilder.greaterThan(root.get("price"), priceLt);
    }

    public Specification<Product> priceLessThan(Integer priceGt) {
        return (root, query, criteriaBuilder) ->
                priceGt == null
                        ? criteriaBuilder.conjunction()
                        : criteriaBuilder.lessThan(root.get("price"), priceGt);

    }

    public Specification<Product> ratingGreaterThan(Double ratingGt) {
        return (root, query, criteriaBuilder) ->
                ratingGt == null
                        ? criteriaBuilder.conjunction()
                        : criteriaBuilder.greaterThan(root.get("rating"), ratingGt);
    }

    public Specification<Product> titleContainsString(String titleCont) {
        return (root, query, criteriaBuilder) ->
                titleCont == null
                        ? criteriaBuilder.conjunction()
                        : criteriaBuilder.like(root.get("title"), titleCont);
    }
}
// END
