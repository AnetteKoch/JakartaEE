package de.oio.jsf;

import javax.annotation.Resource;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.transaction.UserTransaction;

@Transactional
@Interceptor
public class TransactionInterceptor {

	@Resource
	private UserTransaction transaction;

	@AroundInvoke
	public Object manageTransaction(InvocationContext ctx) throws Exception {
		transaction.begin();
		Object result = ctx.proceed();
		transaction.commit();
		return result;
	}

}
