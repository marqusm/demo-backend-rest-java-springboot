package com.marqusm.demobackendrestjavaspringboot.cache;

import com.marqusm.demobackendrestjavaspringboot.BaseIntegrationTest;
import com.marqusm.demobackendrestjavaspringboot.service.PictureService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mock.web.MockMultipartFile;

import java.util.Arrays;

class HashtagSuggestionCacheTest extends BaseIntegrationTest {

  @Autowired HashtagSuggestionCache hashtagSuggestionCache;
  @Autowired PictureService pictureService;

  @SneakyThrows
  @Test
  void getSuggestion() {
    pictureService.createPicture(
        new MockMultipartFile(
            "caucasus.jpg", new ClassPathResource("caucasus.jpg").getInputStream()),
        "The Caucasus",
        Arrays.asList("awesome", "beauty"));
    hashtagSuggestionCache.getSuggestion("awesome");
  }

  @Test
  void invalidate() {}
}
