/**
 *    Copyright (c) 2014-2019 CK.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.github.fartherp.framework.database.service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2015/6/5.
 */
public interface GenericService<T, ID> {
    /**
     * 删除对象
     *
     * @param id id
     */
    void delete(ID id);

    /**
     * 批量删除对象
     */
    void deleteBatch(List<ID> ids);

    /**
     * 查询所有对象
     * @return all data object list
     */
    List<T> findAll();

    /**
     * 通过主键查询对象
     *
     * @param id  data id
     * @return data object
     */
    T findById(ID id);

    /**
     * 查找所有记录数量
     * @return 数量
     */
    long count();

    /**
     * 保存对象
     *
     * @param entity entity
     */
    ID saveEntity(T entity);

    /**
     * 保存对象不为空的属性值(其余为数据库的默认值)
     *
     * @param entity entity
     * @return ID
     */
    ID saveEntitySelective(T entity);

    /**
     * 批量保存
     * @param entitys entitys
     */
    void saveBatch(List<T> entitys);

    /**
     * 更新对象的所有属性
     *
     * @param entity entity
     */
    void updateEntity(T entity);

    /**
     * 更新对象不为空的属性值
     *
     * @param entity entity
     */
    void updateEntitySelective(T entity);

    /**
     * 保存或更新(如果对象已存在)
     *
     * @param entity object
     * @return object
     */
    T saveOrUpdate(T entity);

    /**
     * 保存或更新(如果对象已存在)
     *
     * @param entity object
     * @return object
     */
    T saveOrUpdateSelective(T entity);
}
