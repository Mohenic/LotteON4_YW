package kr.co.lotteon.service;

import kr.co.lotteon.dto.product.ProductDTO;
import kr.co.lotteon.entity.product.ProductEntity;
import kr.co.lotteon.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final ProductRepository productRepository;

    public void save(ProductDTO dto) {
        // 랜덤한 파일 이름 생성
        String randomFilename1 = generateRandomFilename();
        String randomFilename2 = generateRandomFilename();
        String randomFilename3 = generateRandomFilename();
        String randomDetailFilename = generateRandomFilename();

        // ProductDTO에 랜덤한 파일 이름 설정
        dto.setThumb1(randomFilename1);
        dto.setThumb2(randomFilename2);
        dto.setThumb3(randomFilename3);
        dto.setDetail(randomDetailFilename);

        // 나머지 저장 로직
        ProductEntity productEntity = productRepository.save(dto.toEntity());
    }

    // UUID를 사용하여 랜덤한 파일 이름 생성
    private String generateRandomFilename() {
        UUID uuid = UUID.randomUUID();
        String randomFilename = uuid.toString();
        return randomFilename;
    }
}
