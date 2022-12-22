package ru.levelup.homework6.dao.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.levelup.homework6.dao.RegionDao;
import ru.levelup.homework6.model.Region;

import java.sql.Types;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RegionDaoImpl implements RegionDao {
    private final NamedParameterJdbcOperations jdbcOperations;
    private final RowMapper<Region> regionRowMapper =
            (rs, rowNum) -> new Region(rs.getInt("id"),
                    rs.getString("name"));

    @Override
    public List<Region> findAll() {
        final String sql = "SELECT r.id, r.name FROM region r";
        return jdbcOperations.query(sql, regionRowMapper);
    }

    @Override
    public Optional<Region> getById(int regionId) {
        //language=SQL
        String sql = "SELECT r.id, r.name FROM region r " +
                "where r.id = :regionId";
        try {
            return Optional.ofNullable(jdbcOperations.queryForObject(sql, Map.of("regionId", regionId), regionRowMapper));
        } catch (Exception ex) {
            return Optional.empty();
        }
    }
    @Override
    public int create(Region region) {
        final String sqlQuery = "insert into region (id, name) values (:id, :name)";
        MapSqlParameterSource namedParametrs = new MapSqlParameterSource();
        final Integer id = region.getId();
        namedParametrs.addValue("id", id, Types.INTEGER);
        namedParametrs.addValue("name", region.getName(), Types.VARCHAR);
        jdbcOperations.update(sqlQuery, namedParametrs);
        return id;
    }

    @Override
    public void update(Region region) {
        final String sqlQuery = "update region set name = :name" +
                "where id = :regionId";
        jdbcOperations.update(sqlQuery, Map.of(
                "id", region.getId(),
                "name", region.getName()));
    }
    @Override
    public void deleteById(int regionId) {
        //language=SQL
        String sqlQuery = "delete from region r where r.id = :regionId";
        jdbcOperations.update(sqlQuery, Map.of("regionId", regionId));
    }
}
