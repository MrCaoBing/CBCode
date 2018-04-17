package com.haochen.hc0407crm.service.lzm;

import java.util.List;
import java.util.Map;

import com.haochen.hc0407crm.entity.SalChance;

public interface SalChanceService {
	
	/**
	 * ��ѯ���е����ۻ��ᣬ�ɰ�������ģ����ѯ������ҳ
	 * @param ���ݹ����Ĳ�������
	 * @return	����һ����ѯ��Ϣ�Ľ����
	 */
	List<SalChance> findAllSalChanceInfo(Map<String,Object> map);
	
	/**
	 * ��ѯ���ۻ�����ܼ�¼��Ϣ
	 * @return ����һ����Ӱ�������
	 */
	int selectSalChanceCountRecordInfo(Map<String,Object> map);
	
	/**
	 * �������ۻ���
	 * @param ����һ��Ҫ��ӵ����ݶ���
	 * @return ����һ����Ӱ�������,����0��ɹ�
	 */
	int addSalChanceInfo(SalChance salChance);
	
	/**
	 * ɾ�����ۻ���,���ݴ��ݹ����Ĳ���,ɾ��ָ������Ϣ
	 * @param ��������
	 * @return ����һ����Ӱ�������,����0��ɹ�
	 */
	int delSalChanceInfo(Integer chcId);
	
	/**
	 * �޸����ۻ���
	 * @param ����һ��Ҫ�޸ĵ����ݶ���
	 * @return ����һ����Ӱ�������
	 */
	int setSalChanceInfo(Map<String,Object> map);
	
	/**
	 * ����������ѯָ�������ۻ���
	 * @param id
	 * @return
	 */
	SalChance findAppointSalChanceInfo(Integer id);
	
	/**
	 * ���ݿͻ����Ʋ�ѯ�Ƿ���ڿͻ���
	 * @param name
	 * @return
	 */
	SalChance findCheckchcCustName(String name);
}
