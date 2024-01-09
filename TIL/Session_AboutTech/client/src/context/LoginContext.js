import { createContext, useState } from 'react';

// Context 생성
export const LoginContext = createContext();

// Context Provider 구현
export const LoginProvider = ({ children }) => {
  // 로그인 상태를 관리하기 위한 state
  const [isLogin, setIsLogin] = useState(false);

  // Provider에서 제공할 값
  const contextValue = {
    isLogin: isLogin,
    setIsLogin
  };

  return (
    <LoginContext.Provider value={contextValue}>
      {children}
    </LoginContext.Provider>
  );
};
