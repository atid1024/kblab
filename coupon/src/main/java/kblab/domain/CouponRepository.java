package kblab.domain;

import kblab.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="coupons", path="coupons")
public interface CouponRepository extends PagingAndSortingRepository<Coupon, Long>{

}
