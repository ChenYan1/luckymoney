package com.example.luckymoney;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Chen
 * @date 2019/4/10 4:47
 */

/**
 * extends JpaRepository<Luckymoney, Integer>
 *     <数据库实体类，id类型>
 */
public interface LuckmoneyRepository extends JpaRepository<Luckymoney, Integer> {
}
