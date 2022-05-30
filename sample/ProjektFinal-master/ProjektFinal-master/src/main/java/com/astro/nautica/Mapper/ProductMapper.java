package com.astro.nautica.Mapper;

import com.astro.nautica.VO.CategoryDetailsVO;
import com.astro.nautica.VO.CategoryVO;
import com.astro.nautica.VO.ProductOptionVO;
import com.astro.nautica.VO.ProductVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
@Mapper
public interface ProductMapper {
    /**
     * 상품 목록을 ProductVO 리스트 형태로 반환.
     *
     * @return ProductVO 리스트
     */
    List<ProductVO> getAllProducts();

    /**
     * productName이 이름에 들어있는 상품 목록을 ProductVO 리스트 형태로 반환.
     *
     * @param productName 검색 키워드
     * @return ProductVO 리스트
     */
    List<ProductVO> getProducts(String productName);

    /**
     * 해당 제품의 pid로 상품 정보 입수.
     *
     * @param pid 해당 제품의 pid
     * @return ProductVO
     */
    ProductVO getProduct(String pid);

    /**
     * 대분류 목록을 CategoryVO 리스트 형태로 반환.
     *
     * @return CategoryVO 리스트
     */
    List<CategoryVO> getCategories();

    /**
     * 해당 제품명의 존재 여부를 반환.
     *
     * @param productName 제품명
     * @return 제품명 존재 여부
     */
    Boolean isExistProduct(String productName);

    /**
     * 해당 카테고리 ID의 소분류 목록을 CategoryDetails 리스트 형태로 반환.
     *
     * @param categoryId 카테고리 ID
     * @return CategoryDetailVO 리스트
     */
    List<CategoryDetailsVO> getCategoryDetails(String categoryId);

    /**
     * 상품을 등록.
     *
     * @param productVO 등록할 상품
     */
    void addProduct(ProductVO productVO) throws SQLException;

    /**
     * 상품 정보를 수정.
     *
     * @param productVO 정보를 수정할 상품
     */
    void modifyProduct(ProductVO productVO) throws SQLException;

    /**
     * 해당 상품을 삭제.
     *
     * @param pid 삭제할 제품의 pid
     */
    void deleteProduct(String pid) throws SQLException;

    void addProductOptions(List<ProductOptionVO> productOptionVOList) throws SQLException;

    void deleteProductOptions(String pid) throws SQLException;
}
