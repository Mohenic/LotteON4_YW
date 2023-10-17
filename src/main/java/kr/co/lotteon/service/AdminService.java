package kr.co.lotteon.service;

import kr.co.lotteon.dto.product.ProductCate1DTO;
import kr.co.lotteon.dto.product.ProductCate2DTO;
import kr.co.lotteon.dto.product.ProductDTO;
import kr.co.lotteon.entity.product.ProductCate1Entity;
import kr.co.lotteon.entity.product.ProductCate2Entity;
import kr.co.lotteon.entity.product.ProductEntity;
import kr.co.lotteon.repository.product.ProductCate1Repository;
import kr.co.lotteon.repository.product.ProductCate2Repository;
import kr.co.lotteon.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final ProductRepository productRepository;
    private final ProductCate1Repository productCate1Repository;
    private final ProductCate2Repository productCate2Repository;

    public List<ProductEntity> list() {
        return productRepository.findAll();
    }

    public List<ProductCate1Entity> cateList(){
        return productCate1Repository.findAll();
    }

    public List<ProductCate2Entity> cate2List(int cate1){
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
