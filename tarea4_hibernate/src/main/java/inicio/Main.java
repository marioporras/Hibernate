package inicio;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

public class Main {

	public static HibernateUtil hu = new HibernateUtil();

	public static void main(String[] args) {

		

		Date date = new Date();
		byte array[] = { (byte) 0x45, (byte) 0xF5, (byte) 0x3A, (byte) 0x67, (byte) 0xFF };

		TiposBasicos tiposBasicos1 = new TiposBasicos();
		tiposBasicos1.setInte(1);
		tiposBasicos1.setLong1(12);
		tiposBasicos1.setShort1((short) 13);
		tiposBasicos1.setFloat1(14.1F);
		tiposBasicos1.setDouble1(15.2);
		tiposBasicos1.setCharacter1('M');
		tiposBasicos1.setByte1((byte) 16);
		tiposBasicos1.setBoolean1(true);
		tiposBasicos1.setYesno1(true);
		tiposBasicos1.setTruefalse1(true);
		tiposBasicos1.setStri("Probando");
		tiposBasicos1.setDateDate(date);
		tiposBasicos1.setDateTime(date);
		tiposBasicos1.setDateTimestamp(date);
		tiposBasicos1.setTexto(
				"super texto larguisimooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
		tiposBasicos1.setBinario(array);
		tiposBasicos1.setBigDecimal(new BigDecimal("0.2"));
		tiposBasicos1.setBigInteger(new BigInteger("6784930209039"));
													
		TiposBasicos tiposBasicos2 = new TiposBasicos();
		tiposBasicos2.setInte(2);
		tiposBasicos2.setLong1(12);
		tiposBasicos2.setShort1((short) 13);
		tiposBasicos2.setFloat1(14.1F);
		tiposBasicos2.setDouble1(15.2);
		tiposBasicos2.setCharacter1('M');
		tiposBasicos2.setByte1((byte) 16);
		tiposBasicos2.setBoolean1(false); 
		tiposBasicos2.setYesno1(false); 
		tiposBasicos2.setTruefalse1(false); 
		tiposBasicos2.setStri("Probando");
		tiposBasicos2.setDateDate(date);
		tiposBasicos2.setDateTime(date);
		tiposBasicos2.setDateTimestamp(date);
		tiposBasicos2.setTexto(
				"super texto larguisimooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
		tiposBasicos2.setBinario(array);
		tiposBasicos2.setBigDecimal(new BigDecimal("0.2"));
		tiposBasicos2.setBigInteger(new BigInteger("6784930209039"));

		Session s = HibernateUtil.crearSesion();
		s.getTransaction().begin();

		s.save(tiposBasicos1);
		s.save(tiposBasicos2);


		s.getTransaction().commit();
		HibernateUtil.cerrarSesion();

	}

}
