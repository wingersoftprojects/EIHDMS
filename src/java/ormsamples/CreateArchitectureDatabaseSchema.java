/**
 * Licensee: Kiyingi Simon Peter
 * License Type: Purchased
 */
package ormsamples;

import org.orm.*;
public class CreateArchitectureDatabaseSchema {
	public static void main(String[] args) {
		try {
			ORMDatabaseInitiator.createSchema(eihdms.EIHDMSPersistentManager.instance());
			eihdms.EIHDMSPersistentManager.instance().disposePersistentManager();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
