const PROXY_CONFIG = [
  {
    context: [
      "/news"
    ],
    target: "http://localhost:8080",
    secure: false
  }
];

module.exports = PROXY_CONFIG;
