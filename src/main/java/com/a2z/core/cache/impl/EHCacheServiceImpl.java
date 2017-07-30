package com.a2z.core.cache.impl;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.cache.ehcache.EhCacheCacheManager;

import com.a2z.core.cache.CacheServiceResponse;
import com.a2z.core.cache.ICacheService;

public class EHCacheServiceImpl implements ICacheService {
	
	private EhCacheCacheManager cacheManager;

	public EhCacheCacheManager getCacheManager() {
		return cacheManager;
	}

	public void setCacheManager(EhCacheCacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	public CacheServiceResponse clearCache() {
		// TODO Auto-generated method stub
		Collection<String> cacheList = cacheManager.getCacheNames();
		for (Iterator<String> iterator = cacheList.iterator(); iterator.hasNext();) {
			String cacheName = iterator.next();
			System.out.println("CacheName:"+ cacheName);
		}
		
		CacheServiceResponse resp = new CacheServiceResponse(200, "cache cleared Successfully....");
		
		return resp;
	}

	public CacheServiceResponse clearSpecificCache(String cacheName) {
		// TODO Auto-generated method stub
		return null;
	}

	public CacheServiceResponse addEntryToCache(String cacheName, String key, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	public CacheServiceResponse removeEntryFromCache(String cacheName, String key, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	public CacheServiceResponse reloadCache() {
		// TODO Auto-generated method stub
		return null;
	}

	public CacheServiceResponse reloadSpecificCache(String cacheName) {
		// TODO Auto-generated method stub
		return null;
	}

}
