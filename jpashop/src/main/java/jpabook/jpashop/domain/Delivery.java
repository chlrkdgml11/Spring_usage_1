package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter @Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    //enum타입은 Enumerated를 넣어야 한다.
    //ORDINAL(Default) : 숫자로 컬럼이 들어감 ex)READY면 1, COMP면 2 -> 다른 상태가 들어오면 오류
    //STRING : 값이 String으로 들어가서 다른 상태가 들어와도 상관 없음(꼭 String으로 사용)
    private DeliveryStatus status; //READY, COMP
}
