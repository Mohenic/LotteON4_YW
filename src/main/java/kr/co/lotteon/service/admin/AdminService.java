package kr.co.lotteon.service.admin;

import kr.co.lotteon.dto.admin.PageRequestDTO;
import kr.co.lotteon.dto.admin.PageResponseDTO;
import kr.co.lotteon.dto.product.ProductDTO;
import kr.co.lotteon.entity.product.ProductCate1Entity;
import kr.co.lotteon.entity.product.ProductCate2Entity;
import kr.co.lotteon.entity.product.ProductEntity;
import kr.co.lotteon.repository.product.ProductCate1Repository;
import kr.co.lotteon.repository.product.ProductCate2Repository;
import kr.co.lotteon.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class AdminService {
    private final ProductRepository productRepository;
    private final ProductCate1Repository productCate1Repository;
    private final ProductCate2Repository productCate2Repository;
    private final ModelMapper modelMapper;

    // product list 출력 , search
    public PageResponseDTO findByUseyn(PageRequestDTO pageRequestDTO){

        Pageable pageable = pageRequestDTO.getPageable("prodNo");

        Page<ProductEntity> result = productRepository.findByUseyn("Y", pageable);

        List<ProductDTO> dtoList = result.getContent()
                .stream()
                .map(entity -> modelMapper.map(entity, ProductDTO.class))
                .toList();

        int totalElement = (int) result.getTotalElements();

        return PageResponseDTO.builder()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total(totalElement)
                .build();
    }

    public PageResponseDTO findByProdName(PageRequestDTO pageRequestDTO, String prodName){

        Pageable pageable = pageRequestDTO.getPageable("prodNo");

        Page<ProductEntity> result = productRepository.findByProdNameLike("%" + prodName + "%", pageable);

        List<ProductDTO> dtoList = result.getContent()
                .stream()
                .map(entity -> modelMapper.map(entity, ProductDTO.class))
                .toList();

        int totalElement = (int) result.getTotalElements();

        return PageResponseDTO.builder()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total(totalElement)
                .build();
    }
    public PageResponseDTO findByProdNo(PageRequestDTO pageRequestDTO, int prodNo){

        Pageable pageable = pageRequestDTO.getPageable("prodNo");

        Page<ProductEntity> result = productRepository.findByProdNoLike(prodNo, pageable);

        List<ProductDTO> dtoList = result.getContent()
                .stream()
                .map(entity -> modelMapper.map(entity, ProductDTO.class))
                .toList();

        int totalElement = (int) result.getTotalElements();

        return PageResponseDTO.builder()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total(totalElement)
                .build();
    }
    public PageResponseDTO findByCompany(PageRequestDTO pageRequestDTO, String company){

        Pageable pageable = pageRequestDTO.getPageable("prodNo");

        Page<ProductEntity> result = productRepository.findByCompanyLike("%" + company + "%", pageable);

        List<ProductDTO> dtoList = result.getContent()
                .stream()
                .map(entity -> modelMapper.map(entity, ProductDTO.class))
                .toList();

        int totalElement = (int) result.getTotalElements();

        return PageResponseDTO.builder()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total(totalElement)
                .build();
    }

    public PageResponseDTO findBySeller(PageRequestDTO pageRequestDTO, String seller){

        Pageable pageable = pageRequestDTO.getPageable("prodNo");

        Page<ProductEntity> result = productRepository.findBySellerLike("%" + seller + "%", pageable);

        List<ProductDTO> dtoList = result.getContent()
                .stream()
                .map(entity -> modelMapper.map(entity, ProductDTO.class))
                .toList();

        int totalElement = (int) result.getTotalElements();

        return PageResponseDTO.builder()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total(totalElement)
                .build();
    }

    // product list delete

    public int deleteByProdNo(List<Integer> prodNos) {
        int deletedCount = 0;

        for (Integer prodNo : prodNos) {
            List<ProductEntity> productEntities = productRepository.findByProdNo(prodNo);

            if (productEntities != null && !productEntities.isEmpty()) {
                for (ProductEntity productEntity : productEntities) {
                    productEntity.setUseyn("N"); // 변경할 필드 설정
                }

                // 변경된 엔티티 저장
                productRepository.saveAll(productEntities);
                deletedCount += productEntities.size();
            }
        }

        return deletedCount; // 삭제된 엔티티 수 반환
    }


    // product register

    public List<ProductCate1Entity> cateList(){
        return productCate1Repository.findAll();
    }

    public List<ProductCate2Entity> cate2List(int cate1){

        log.info("service cate2 : " + productCate2Repository.findAllByCate1(cate1));

        return productCate2Repository.findAllByCate1(cate1);
    }

    public void save(ProductDTO dto) {
        // 랜덤한 파일 이름 생성
        String randomFilename1 = generateRandomFilename(dto.getFileThumb1().getOriginalFilename());
        String randomFilename2 = generateRandomFilename(dto.getFileThumb2().getOriginalFilename());
        String randomFilename3 = generateRandomFilename(dto.getFileThumb3().getOriginalFilename());
        String randomDetailFilename = generateRandomFilename(dto.getFileDetail().getOriginalFilename());

        ProductEntity entity = dto.toEntity();

        // ProductDTO에 랜덤한 파일 이름 설정
        entity.setThumb1(randomFilename1);
        entity.setThumb2(randomFilename2);
        entity.setThumb3(randomFilename3);
        entity.setDetail(randomDetailFilename);

        // 나머지 저장 로직
        ProductEntity productEntity = productRepository.save(entity);

        // 파일을 경로에 저장
        String uploadPath = "src/main/resources/static/file/"+dto.getProdCate1()+"/"+dto.getProdCate2()+"/";
        saveFile(uploadPath, dto.getFileThumb1(), randomFilename1);
        saveFile(uploadPath, dto.getFileThumb2(), randomFilename2);
        saveFile(uploadPath, dto.getFileThumb3(), randomFilename3);
        saveFile(uploadPath, dto.getFileDetail(), randomDetailFilename);
    }

    // 파일을 실제 경로에 저장하는 메소드
    private void saveFile(String uploadPath, MultipartFile fileData, String fileName) {
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        try {
            byte[] bytes = fileData.getBytes();
            Path path = Paths.get(uploadPath + fileName);
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // UUID를 사용하여 랜덤한 파일 이름을 생성하고 원래 파일의 확장자를 유지
    private String generateRandomFilename(String originalFilename) {
        String fileExtension = "";
        int lastDotIndex = originalFilename.lastIndexOf(".");

        if (lastDotIndex >= 0) {
            fileExtension = originalFilename.substring(lastDotIndex);
        }

        UUID uuid = UUID.randomUUID();
        String randomFilename = uuid.toString() + fileExtension;

        return randomFilename;
    }

}
