package com.comapny.testatricle.repository;

import com.comapny.testatricle.model.arcticle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface articleRepo extends MongoRepository<arcticle, String> {
}
