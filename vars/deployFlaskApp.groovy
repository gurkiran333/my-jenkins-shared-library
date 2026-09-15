def call(String dockerImage, String imageTag) {

    echo "Starting Flask application deployment"
    echo "Image: ${dockerImage}:${imageTag}"

    sh """
        docker rm -f flaskapp || true

        docker run -d \
        --name flaskapp \
        -p 5000:5000 \
        ${dockerImage}:${imageTag}
    """

    echo "Flask application deployed successfully"
}
